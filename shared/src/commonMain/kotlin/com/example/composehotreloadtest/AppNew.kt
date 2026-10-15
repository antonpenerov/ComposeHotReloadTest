package com.example.composehotreloadtest

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import composehotreloadtest.shared.generated.resources.Res
import composehotreloadtest.shared.generated.resources.compose_multiplatform
import composehotreloadtest.shared.generated.resources.reload
import composehotreloadtest.shared.generated.resources.star

private val AppColorScheme = darkColorScheme(
    primary = Color(0xFFD4B8FF),
    onPrimary = Color(0xFF30164C),
    primaryContainer = Color(0xFF4B326D),
    onPrimaryContainer = Color(0xFFF2E6FF),
    secondary = Color(0xFFFFB2BF),
    onSecondary = Color(0xFF541D32),
    secondaryContainer = Color(0xFF613142),
    onSecondaryContainer = Color(0xFFFFDAE0),
    tertiary = Color(0xFF83E8D0),
    onTertiary = Color(0xFF00392C),
    tertiaryContainer = Color(0xFF1A5144),
    onTertiaryContainer = Color(0xFFA5F5E1),
    background = Color(0xFF15111D),
    onBackground = Color(0xFFF3EFF8),
    surface = Color(0xFF201A2C),
    onSurface = Color(0xFFF3EFF8),
    surfaceVariant = Color(0xFF3A3246),
    onSurfaceVariant = Color(0xFFD4C9DE),
    outline = Color(0xFFA79AAF),
)

private val tagColors = listOf(
    AppColorScheme.primary,
    AppColorScheme.secondary,
    AppColorScheme.tertiary,
    Color(0xFFF8D37C),
    Color(0xFF8BC8FF),
)

@Composable
@Preview
fun AppNew130beta02() {
    MaterialTheme(colorScheme = AppColorScheme) {
        var showContent by remember { mutableStateOf(false) }
        var textFieldValue by remember { mutableStateOf("") }
        var sliderValue by remember { mutableStateOf(0.5f) }
        var switchState by remember { mutableStateOf(false) }
        var checkboxState by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("Option") }
        var selectedTag by remember { mutableStateOf<Int?>(null) }
        var selectedMode by remember { mutableStateOf("Focus") }
        var notesDone by remember { mutableStateOf(false) }
        var paletteDone by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(MaterialTheme.colorScheme.background, MaterialTheme.colorScheme.primaryContainer)
                    )
                )
                .safeContentPadding()
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.tertiary)),
                        shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
                    )
                    .padding(vertical = 20.dp),
                contentAlignment = Alignment.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painterResource(Res.drawable.star),
                            contentDescription = null,
                            modifier = Modifier.size(74.dp),
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            "Test Hot Reload",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(Res.drawable.reload),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(30.dp),
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        "Fresh controls and live colors",
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                listOf(
                    "Light ${(sliderValue * 100).toInt()}%",
                    if (switchState) "Switch on" else "Switch test",
                    if (checkboxState) "Checked" else "Ready",
                ).forEachIndexed { index, label ->
                    Card(
                        modifier = Modifier.weight(1f),
                        colors = CardDefaults.cardColors(
                            containerColor = tagColors[index].copy(alpha = 0.18f)
                        ),
                        shape = RoundedCornerShape(12.dp),
                    ) {
                        Text(
                            label,
                            color = tagColors[index],
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                Text(
                    "Quick actions",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(listOf("Focus", "Explore", "Share").size) { index ->
                        val mode = listOf("Focus", "Explore", "Share")[index]
                        FilterChip(
                            selected = selectedMode == mode,
                            onClick = { selectedMode = mode },
                            label = { Text(mode) },
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(0.8f),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column {
                            Text("Mini checklist", fontWeight = FontWeight.Bold)
                            Text(
                                "Mode: $selectedMode",
                                color = MaterialTheme.colorScheme.primary,
                                style = MaterialTheme.typography.bodySmall,
                            )
                        }
                        Text(
                            "${listOf(notesDone, paletteDone).count { it }}/2",
                            color = MaterialTheme.colorScheme.tertiary,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = notesDone, onCheckedChange = { notesDone = it })
                        Text("Write a note")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = paletteDone, onCheckedChange = { paletteDone = it })
                        Text("Choose a color tag")
                    }
                    TextButton(
                        onClick = {
                            notesDone = false
                            paletteDone = false
                            selectedMode = "Focus"
                        },
                        modifier = Modifier.align(Alignment.End),
                    ) {
                        Text("Reset checklist")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { showContent = !showContent },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            ) {
                Text("Button!")
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                label = { Text("Enter text") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Slider: ${(sliderValue * 100).toInt()}%",
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.SemiBold,
            )
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            LinearProgressIndicator(
                progress = { sliderValue },
                modifier = Modifier.fillMaxWidth(0.8f),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.secondaryContainer,
            )

            Spacer(modifier = Modifier.height(9.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Switch:")
                Spacer(modifier = Modifier.width(4.dp))
                Switch(
                    checked = switchState,
                    onCheckedChange = { switchState = it }
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.8f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkboxState,
                    onCheckedChange = { checkboxState = it }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Checkbox")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                Text("Radio :")
                listOf("Test 1", "Test 2").forEach { option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOption == option,
                            onClick = { selectedOption = option }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(option)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(0.8f),
                color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = selectedTag?.let { "Tags: Tag ${it + 1} selected" } ?: "Tags: choose a color",
                modifier = Modifier.fillMaxWidth(0.8f),
                color = selectedTag?.let { tagColors[it] } ?: MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(modifier = Modifier.fillMaxWidth(0.9f)) {
                items(tagColors.size) { index ->
                    val color = tagColors[index]
                    val isSelected = selectedTag == index
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .height(36.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isSelected) color else color.copy(alpha = 0.25f)
                        ),
                        shape = RoundedCornerShape(18.dp),
                        onClick = { selectedTag = if (isSelected) null else index },
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(
                                "Tag ${index + 1}",
                                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else color,
                                fontWeight = FontWeight.Medium,
                            )
                        }
                    }
                }
            }

            AnimatedVisibility(visible = selectedTag != null) {
                val selectedColor = selectedTag?.let { tagColors[it] } ?: Color.Transparent
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .padding(top = 12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = selectedColor.copy(alpha = 0.16f),
                    ),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Text(
                        text = "Palette ready — tap the selected tag again to clear it.",
                        color = selectedColor,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(showContent) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Spacer(modifier = Modifier.height(18.dp))
                        Text(
                            "Compose: $greeting",
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Input: $textFieldValue", style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}
