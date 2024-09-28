<template>
  <div class="login-view">
    <el-card class="login-card">
      <template #header>
        <h2 class="text-2xl font-bold">登录</h2>
      </template>
      <el-form :model="loginForm" @submit.prevent="handleLogin">
        <el-form-item label="用户名">
          <el-input v-model="loginForm.username" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="loginForm.password" type="password" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" native-type="submit">登录</el-button>
        </el-form-item>
      </el-form>
      <div class="mt-4 text-center">
        <router-link>没有账号？立即注册</router-link>
      </div>
    </el-card>
  </div>
</template>

<script setup>

</script>

<style scoped>
.login-view {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.login-card {
  width: 100%;
  max-width: 400px;
}
</style>