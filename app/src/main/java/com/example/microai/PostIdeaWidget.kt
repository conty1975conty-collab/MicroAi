package com.example.microai

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.actionStartActivity
import androidx.glance.action.actionParametersOf
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.Button
import androidx.glance.GlanceTheme

val promptParamKey = ActionParameters.Key<String>("PROMPT_TYPE")

class PostIdeaWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                Column(
                    modifier = GlanceModifier
                        .fillMaxSize()
                        .padding(12.dp)
                        .background(GlanceTheme.colors.widgetBackground),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "⚡ MicroAI Идеи",
                        style = TextStyle(color = GlanceTheme.colors.onSurface)
                    )
                    Spacer(modifier = GlanceModifier.height(8.dp))
                    Row(modifier = GlanceModifier.fillMaxWidth()) {
                        Button(
                            text = "🔥 Тренды",
                            onClick = actionStartActivity<QuickPromptActivity>(
                                actionParametersOf(promptParamKey to "trends")
                            )
                        )
                        Spacer(modifier = GlanceModifier.defaultWeight())
                        Button(
                            text = "✍️ Хуки",
                            onClick = actionStartActivity<QuickPromptActivity>(
                                actionParametersOf(promptParamKey to "hooks")
                            )
                        )
                    }
                }
            }
        }
    }
}

class PostIdeaWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = PostIdeaWidget()
}
