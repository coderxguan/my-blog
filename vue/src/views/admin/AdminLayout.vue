<template>
  <el-container class="admin-layout">
    <!-- 侧边栏 -->
    <el-aside width="180px"  class="sidebar">
      <el-menu
          :default-active="activeIndex"
          class="el-menu-vertical"
          @select="handleMenuSelect"
          background-color="#fff"
          text-color="#303133"
          active-text-color="#409EFF"
          >
        <div class="logo-container">
          <router-link to="public" class="image-link">
            <img src="@/assets/images/logo.png" alt="Logo" class="logo" >
          </router-link>
        </div>
        <div class="menu-item">
          <el-menu-item index="1">
            <el-icon class="icon"><PieChart/></el-icon>
            <template #title><span class="nav">仪表盘</span></template>
          </el-menu-item>
        </div>
        <div class="menu-item">
        <el-menu-item index="2">
          <el-icon class="icon"><Document /></el-icon>
          <template #title ><span class="nav">文章管理</span></template>
        </el-menu-item>
        </div>
        <div class="menu-item">
        <el-menu-item index="3">
          <el-icon class="icon"><TrendCharts /></el-icon>
          <template #title ><span class="nav">分类管理</span></template>
        </el-menu-item>
        </div>
        <div class="menu-item">
        <el-menu-item index="4">
          <el-icon class="icon"><ChatDotSquare /></el-icon>
          <template #title ><span class="nav">评论管理</span></template>
        </el-menu-item>
        </div>
        <div class="menu-item">
        <el-menu-item index="5">
          <el-icon class="icon"><EditPen /></el-icon>
          <template #title ><span class="nav">文章编辑</span></template>
        </el-menu-item>
        </div>
        <div class="menu-item">
          <el-menu-item index="6">
            <el-icon class="icon"><Avatar/></el-icon>
            <template #title ><span class="nav">个人中心</span></template>
          </el-menu-item>
        </div>

      </el-menu>
    </el-aside>

    <!-- 右侧内容区域 -->
    <el-container>
      <!-- 顶部导航栏 -->
      <el-header class="header">
        <div class="header-content">
          <div class="header-right">
            <el-input
                placeholder="搜索..."
                prefix-icon="Search"
                v-model="searchQuery"
                class="search-input"
            />
            <el-badge :value="3" class="notification-badge">
              <el-icon><Bell /></el-icon>
            </el-badge>
            <el-dropdown>
              <div class="user-info">
                <el-avatar :size="32" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" />
                <span class="username">admin</span>
              </div>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item>修改密码</el-dropdown-item>
                  <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </div>
        </div>
      </el-header>

      <!-- 动态内容 -->
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup>
import {onMounted, ref} from 'vue';
import { Avatar, ChatDotSquare, PieChart, EditPen, Document, TrendCharts, Bell } from '@element-plus/icons-vue';
import router from "@/router";

const activeIndex = ref();
const searchQuery = ref('');

// 使用 onMounted 生命周期钩子在组件挂载时获取当前路径
onMounted(() => {
  const path = window.location.pathname; // 获取当前路径
  // 根据当前路径设置 activeIndex
  switch (path) {
    case '/admin':
      activeIndex.value = '1';
      break;
    case '/admin/articles':
      activeIndex.value = '2';
      break;
    case '/admin/category':
      activeIndex.value = '3';
      break;
    case '/admin/comment':
      activeIndex.value = '4';
      break;
    case '/admin/edit':
      activeIndex.value = '5';
      break;
    case '/admin/uc':
      activeIndex.value = '6';
      break;
    default:
      activeIndex.value = '1'; // 默认高亮第一项
  }
});

const handleMenuSelect = (index) => {
  activeIndex.value = index;
  switch (index) {
    case '1':
      router.push('/admin');
      break;
    case '2':
      router.push('/admin/articles');
      break;
    case '3':
      router.push('/admin/category');
      break;
    case '4':
      router.push('/admin/comment');
      break;
    case '5':
      router.push('/admin/edit');
      break;
    case '6':
      router.push('/admin/uc');
      break;
  }
};

const logout = () => {
  // 实现登出逻辑
  console.log('登出');
};
</script>

<style scoped>

.admin-layout {
  height: 100vh;
  display: flex;
}

.sidebar {
  flex-direction: column;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12);
}

.logo-container {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.image-link {
  display: inline-block;
  cursor: pointer;
}
.el-menu-item.is-active {
  background-color: #a0cfff;
  color: #303133;
  border-radius: 5px;
}

.menu-item {
  padding: 0 8px;
}
.el-menu-item:hover{
  background-color: #ebedf0;
  color: #303133;
  border-radius: 5px;
}
.icon{
  margin-right: 15px;
}
.nav{
  font-weight: 550;
}
.logo {
  height: 32px;
  display: flex;
}

.header {
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12);
}

.header-content {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 100%;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 20px;
}

.user-info {
  display: flex;
  align-items: center;
}

.username {
  margin-left: 10px;
}


.search-input {
  width: 200px;
  margin-right: 20px;
}

.notification-badge {
  font-size: 20px;
  cursor: pointer;
  margin-right: 20px;
}

.el-main {
  background-color: #f0f2f5;
  padding: 20px;
}
</style>