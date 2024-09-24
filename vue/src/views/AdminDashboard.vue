<template>
  <div>
    <h1>后台管理</h1>
    <router-link to="/admin/articles">管理文章</router-link>
    <router-link to="/admin/statistics">查看统计</router-link>
  </div>
</template>

<script>
export default {
  name: 'AdminDashboard',
};
</script>

<style scoped>
/* 后台管理样式 */
</style>
