import ComposeApp
import SwiftUI

@main
struct iOSApp: App {

	init() {
		IosPlatformModulesKt.doInitKoin()
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}