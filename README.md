# Compose Hot Reload testing checklist

Specify the Compose Hot Reload (CHR) version in [`gradle/libs.versions.toml`](./gradle/libs.versions.toml)
using the `composeHotReload` entry under `[versions]`.

Use this checklist when testing the desktop app in the IDE.

For Compose Hot Reload checks, use the `compose-hot-reload` MCP server configured in [`.mcp.json`](./.mcp.json).

## Run configurations

- [ ] Starting with IDE version 2026.1, a CHR run configuration is created automatically for the desktop app. Its name has a 🔥 emoji and a `hot` suffix.
- [ ] A regular desktop run configuration without CHR is available from the editor gutter's run configuration list.
- [ ] Running the CHR configuration launches the desktop app in Hot Reload mode.

## Reload triggers and settings

- [ ] Saving project changes triggers a reload when the corresponding setting is enabled.
- [ ] Pressing `⌥⌘,` triggers a reload when the corresponding setting is enabled.
- [ ] Clicking **Reload** in the development tools triggers a reload.
- [ ] Running the `reload` Gradle task triggers a reload.
- [ ] Selecting **Reload** from the running Gradle process triggers a reload.
- [ ] Selecting **Reload** from the floating toolbar triggers a reload.
- [ ] CHR settings are available under **Tools > Compose Hot Reload**.
- [ ] With **Reload after Save all** enabled, saving code changes reloads the UI.
- [ ] With **Reload with an assigned shortcut** enabled, pressing `⌥⌘,` reloads the UI.
- [ ] With **Reload on external changes for this project** enabled, changes made outside this IDE (for example, in another IDE or by Junie) trigger a reload.
- [ ] **Reloaded scopes highlighting mode** works in all three modes: **Gutter** highlights the gutter beside a reloaded function, **Editor** highlights the reloaded function's code, and **Disabled** shows no highlight.

## Hot Reload development tools

- [ ] The development tools window appears when the app is launched in Hot Reload mode and moves together with the main app window.
- [ ] Reload status is green after a successful reload, red after a failed reload or when reloading is unavailable, and orange while reloading is in progress.
- [ ] **Reload UI** forces a UI reload with automatic reload settings enabled or disabled, including when changes have not been saved.
- [ ] **Reset UI** resets the app's UI state: it returns to the home screen and variables return to their default values.
- [ ] **Show logs** opens a separate window with CHR execution logs.
- [ ] **Restart the application** stops the current `hotRun` Gradle task, closes the desktop app, starts a new task, and launches the app again.
- [ ] **Close the application** closes the desktop app and stops the `hotRun` Gradle task.
- [ ] **Show notification** appears only after a reload failure and opens a separate CHR Notifications window showing the reason for the failure.

## Floating toolbar

- [ ] The toolbar appears only while the app is running and disappears when the app finishes.
- [ ] The toolbar shows reload status (green, red, or orange) and provides **Reload UI**, **Reset UI**, and an option to hide the toolbar.

## Code changes

- [ ] Changes in the JVM source set are applied.
- [ ] Changes in the shared source set are applied.
- [ ] Adding, removing, and editing files, classes, functions, and variables are applied.
- [ ] Adding, removing, and editing composable elements are applied.
