<template>
  <div class="admin-dashboard">
    <h1 class="text-2xl font-bold mb-6">仪表盘</h1>
    <el-row :gutter="20">
      <el-col :span="6" v-for="(stat, index) in stats" :key="index">
        <el-card class="mb-4">
          <template #header>
            <div class="card-header">
              <span>{{ stat.label }}</span>
            </div>
          </template>
          <div class="text-center">
            <h3 class="text-4xl font-bold">{{ stat.value }}</h3>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :span="12">
        <el-card>
          <template #header>
            <div class="card-header">
              <span>最近文章</span>
            </div>
          </template>
          <el-table  style="width: 100%">

          </el-table>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card>
          <template #header>
            <div class="card-header">
              <span>最近评论</span>
            </div>
          </template>
          <el-table  style="width: 100%">

          </el-table>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script >
export default {
  name: "AdminDashboardView"
}

</script>