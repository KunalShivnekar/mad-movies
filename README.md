# MAD Movies
This is a sample app demonstrating usage of Modern Android Development (MAD) tools.

Each branch differs from other in terms of stack used or design principles followed.

## Samples
### mvvm-fragments
- UI: Fragment, Recycler View, Constraint Layout and XML.
- Uses ViewBinding between UI and Fragment. Picasso for image loading.
- MVVM based on `androidx.lifecycle` components LiveData and ViewModel.
- Dependency Injection: Hilt
- Networking: Retrofit, GSON
- Multi-modular approach.
- Kotlin with Coroutines

### mvvm-fragments-compose
- uses Jetpack Compose for UI embedded inside Fragment
- rest same as mvvm-fragments

### mvvm-compose-navigation
- uses Jetpack Compose for UI with Jetpack Compose Navigation 
- Stateflow instead of LiveData in ViewModel


    

