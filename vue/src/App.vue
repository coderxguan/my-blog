<template>
  <div id="app">
    <header>
      <nav>
        <router-link to="/">主页</router-link>
        <router-link to="/login">登录</router-link>
        <router-link to="/admin">后台管理</router-link>
      </nav>
    </header>
    <main>
      <router-view></router-view> <!-- 当前路由的组件将在这里渲染 -->
    </main>
    <footer>
      <p>© 2024 我的博客</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: 'App',
};
</script>

<style>
/* 基本样式 */
header {
  background-color: #f8f9fa;
  padding: 10px;
}

nav {
  display: flex;
  gap: 15px;
}
</style>
