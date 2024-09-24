import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import Article from '../views/Article.vue';
import Login from '../views/Login.vue';
import AdminDashboard from '../views/AdminDashboard.vue';
import AdminArticles from '../views/AdminArticles.vue';
import AdminEditArticle from '../views/AdminEditArticle.vue';
import AdminStatistics from '../views/AdminStatistics.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/article/:id', component: Article }, // 动态路由
    { path: '/login', component: Login },
    { path: '/admin', component: AdminDashboard },
    { path: '/admin/articles', component: AdminArticles },
    { path: '/admin/edit/:id?', component: AdminEditArticle }, // 可选的动态路由
    { path: '/admin/statistics', component: AdminStatistics },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
