package com.example.microai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp

class QuickPromptActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val promptType = intent.getStringExtra("PROMPT_TYPE") ?: "general"

        setContent {
            MaterialTheme {
                Surface(
                    shape = RoundedCornerShape(24.dp),
                    color = MaterialTheme.colorScheme.surfaceContainerHigh,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(16.dp)
                ) {
                    var resultText by remember { mutableStateOf("⚡ Генерация ответа ИИ...") }
                    val clipboardManager = LocalClipboardManager.current

                    LaunchedEffect(Unit) {
                        // Имитация мгновенного вызова ИИ (менее 1 сек)
                        kotlinx.coroutines.delay(800)
                        resultText = when(promptType) {
                            "trends" -> "🔥 Трэнд дня: Запиши видео о том, как виджеты Android ускоряют работу в 3 раза!"
                            "hooks" -> "✍️ Хук: Перестань открывать ChatGPT — делай всё прямо с рабочего стола."
                            else -> "💡 Идея: Сделай обзор на минималистичные утилиты."
                        }
                    }

                    Column(modifier = Modifier.padding(20.dp)) {
                        Text("MicroAI Assist", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(resultText, style = MaterialTheme.typography.bodyLarge)
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                            TextButton(onClick = { finish() }) { Text("Закрыть") }
                            Spacer(modifier = Modifier.width(8.dp))
                            Button(onClick = {
                                clipboardManager.setText(AnnotatedString(resultText))
                                finish()
                            }) { Text("Скопировать") }
                        }
                    }
                }
            }
        }
    }
}
