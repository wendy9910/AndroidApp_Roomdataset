package com.example.appwithroom.ui.theme.userinput

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.shadow
import java.io.File
import androidx.compose.ui.graphics.Color

//新增使用者
@Composable
fun UserInfoInputScreen(
    navController: NavController,
    viewModel: UserInputViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var imagePath by remember { mutableStateOf("") }
    var featureVector by remember { mutableStateOf(ByteArray(128) { 0 }) }

    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
    val imagePathFromCamera = savedStateHandle?.get<String>("capturedImagePath")
    if (imagePathFromCamera != null) {
        imagePath = imagePathFromCamera
        savedStateHandle.remove<String>("capturedImagePath")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "新增使用者資訊",
            style = MaterialTheme.typography.titleLarge
        )

        Button(
            //切換到拍照畫面
            onClick = { navController.navigate("take_photo") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("開啟相機拍照")
        }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("使用者名稱") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        //確認相片是否存在，存在則顯示
        if (imagePath.isNotEmpty()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("照片預覽", style = MaterialTheme.typography.titleMedium)

                    val painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(File(imagePath))
                            .crossfade(true)
                            .build()
                    )

                    Image(
                        painter = painter,
                        contentDescription = "拍照成果",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Text(
                        text = imagePath,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = {
                    //模擬特徵
                    featureVector = ByteArray(512) { (0..255).random().toByte() }
                    viewModel.addUser(name, imagePath, featureVector)
                    Toast.makeText(context, "使用者已新增！", Toast.LENGTH_SHORT).show()
                    name = ""
                    imagePath = ""
                    navController.popBackStack()
                },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("新增使用者")
            }

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("返回")
            }
        }
    }
}
