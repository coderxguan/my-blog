import { createApp } from 'vue'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router'
import App from './App.vue'




const app = createApp(App)


// 使用 Vue Router
app.use(router)
// 使用 Element Plus
app.use(ElementPlus)
app.mount('#app')