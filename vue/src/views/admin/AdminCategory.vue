<template>
  <div class="category-management">
    <h1 class="text-2xl font-bold mb-6">分类管理</h1>
    <el-button class="add-button" type="primary" @click="openAddCategoryDialog">添加分类</el-button>
    <el-table :data="categories" style="width: 100%" stripe>
      <el-table-column prop="name" label="分类名称" />
      <el-table-column label="操作">
        <template #default="{ row }">
          <el-button @click="editCategory(row)" size="small" type="warning">编辑</el-button>
          <el-button @click="deleteCategory(row.id)" size="small" type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加分类对话框 -->
    <el-dialog v-model="addDialogVisible" title="添加分类">
      <el-form :model="newCategory">
        <el-form-item label="分类名称" :rules="[{ required: true}]">
          <el-input v-model="newCategory.name" placeholder="请输入分类名称..."/>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="addDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addCategory">确 定</el-button>
      </template>
    </el-dialog>

    <!-- 编辑分类对话框 -->
    <el-dialog v-model="editDialogVisible" title="编辑分类">
      <el-form :model="currentCategory">
        <el-form-item label="分类名称" :rules="[{ required: true }]">
          <el-input v-model="currentCategory.name" placeholder="请输入分类名称..." />
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="editDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="updateCategory">确 定</el-button>
      </template>
    </el-dialog>

  </div>
</template>

<script setup>
import {onMounted, ref} from 'vue';
import { ElMessage} from 'element-plus';
import {fetchCategories} from "@/api/category.js";
import {addCategoryToServer} from "@/api/category.js";
import {deleteCategoryFromServer} from "@/api/category.js";
import {updateCategoryToServer} from "@/api/category.js";

const categories = ref([]);
const addDialogVisible = ref(false);
const editDialogVisible = ref(false);
const newCategory = ref({ name: '' });
const currentCategory = ref({id: null, name: ''});

// 页面加载时从后端获取的分类数据
const loadCategories = async () => {
  try {
    categories.value = await fetchCategories();
    console.log(categories.value);
  }catch(error) {
    ElMessage.error('获取分类数据失败');
  }
};

// 添加分类
const addCategory = async () => {
  if (!newCategory.value.name) {
    ElMessage.error('分类名称不能为空');
    return;
  }

  try{
    const response = await addCategoryToServer(newCategory.value);
    console.log(response);
    if(response.code === 1){
      categories.value.push(response.data);  // 将新内容添加到列表
      newCategory.value = {name: ''};
      addDialogVisible.value = false;
      ElMessage.success('分类添加成功');
    }else if(response.code === 0){
      newCategory.value = {name: ''};
      addDialogVisible.value = false;
      ElMessage.error(response.msg);
    }
  } catch (error) {
    ElMessage.error("添加分类失败");
  }

};

// 编辑分类
const editCategory = (category) => {
  currentCategory.value = { ...category};  // 回显数据
  editDialogVisible.value = true;
};

// 更新分类
const updateCategory = async () => {
  try {
    const response = await updateCategoryToServer(currentCategory.value);
    if (response.code === 1) {
      // 更新完后重新加载页面
      await loadCategories();
      editDialogVisible.value = false; // 关闭对话框
      ElMessage.success('分类更新成功');
    } else {
      ElMessage.error(response.msg);
    }
  } catch (error) {
    ElMessage.error("更新分类失败");
  }
};

// 删除分类
const deleteCategory = async(id) => {
  try {
    // 调用后端删除接口
    const response = await deleteCategoryFromServer(id);
    console.log(response);
    if (response.code === 1) {
      // 如果删除成功，从本地数组中移除分类
      categories.value = categories.value.filter((category) => category.id !== id);
      ElMessage.success('分类删除成功');
    } else {
      ElMessage.error(response.msg);
    }
  } catch (error) {
    ElMessage.error("删除分类失败");
  }
};

// 打开添加分类对话框
const openAddCategoryDialog = () => {
  addDialogVisible.value = true;
};

// 页面加载时获取分类数据
onMounted(loadCategories);
</script>

<style scoped>
.category-management {
  padding: 20px;
}

.add-button{
  margin-bottom: 20px;
}
</style>
