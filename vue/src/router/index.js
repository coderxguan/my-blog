import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/public/HomeView.vue'
import ArticleView from '@/views/public/ArticleView.vue'
import LoginView from '@/views/public/LoginView.vue'
import AdminLayoutComponent from '@/views/admin/AdminLayout.vue'
import AdminDashboardView from '@/views/admin/AdminDashboardView.vue'
import AdminArticlesView from '@/views/admin/AdminArticlesView.vue'
import AdminCategory from "@/views/admin/AdminCategory.vue";
import AdminComment from "@/views/admin/AdminComment.vue";
import AdminEdit from "@/views/admin/AdminEdit.vue";
import AdminUC from "@/views/admin/AdminUC.vue";

const routes = [
    { path: '/', name: 'home', component: HomeView },
    { path: '/login', name: 'login', component: LoginView },
    { path: '/public', name: 'public', component: ArticleView },
    {
        path: '/admin',
        component: AdminLayoutComponent,
        meta: { requiresAuth: true },
        children: [
            { path: '', name: 'admin-dashboard', component: AdminDashboardView },
            { path: 'articles', name: 'admin-articles', component: AdminArticlesView },
            { path: 'category', name: 'admin-category', component: AdminCategory },
            { path: 'comment', name: 'admin-comment', component: AdminComment },
            { path: 'edit', name: 'admin-edit', component: AdminEdit },
            { path: 'uc', name: 'admin-uc', component: AdminUC },
        ]
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})



export default router