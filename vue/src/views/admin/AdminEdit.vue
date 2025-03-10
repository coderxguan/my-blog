<script setup>
import { ref } from 'vue';
import { ElForm, ElFormItem, ElInput, ElButton, ElSelect, ElOption, ElDatePicker, ElUpload, ElMessage } from 'element-plus';
import { createArticle } from '@/api/article';

const form = ref({
  title: '',
  content: '',
  category: '',
  publishDate: '',
  coverImage: ''
});

const rules = {
  title: [
    { required: true, message: 'Please input the title', trigger: 'blur' },
    { min: 3, max: 50, message: 'Length should be 3 to 50', trigger: 'blur' }
  ],
  content: [
    { required: true, message: 'Please input the content', trigger: 'blur' }
  ],
  category: [
    { required: true, message: 'Please select a category', trigger: 'change' }
  ],
  publishDate: [
    { type: 'date', required: true, message: 'Please pick a publish date', trigger: 'change' }
  ]
};

const submitForm = async (formEl) => {
  if (!formEl) return;
  formEl.validate(async (valid) => {
    if (valid) {
      try {
        await createArticle(form.value);
        ElMessage.success('Article created successfully');
      } catch (error) {
        ElMessage.error('Failed to create article');
        console.error('Failed to create article:', error);
      }
    } else {
      ElMessage.error('Please fill in the form correctly');
      return false;
    }
  });
};

const handleUploadSuccess = (response, file) => {
  form.value.coverImage = URL.createObjectURL(file.raw);
};
</script>

<template>
  <div class="admin-edit">
    <el-form :model="form" :rules="rules" ref="form" label-width="120px" class="demo-ruleForm">
      <el-form-item label="Title" prop="title">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="Content" prop="content">
        <el-input type="textarea" v-model="form.content"></el-input>
      </el-form-item>
      <el-form-item label="Category" prop="category">
        <el-select v-model="form.category" placeholder="Select category">
          <el-option label="Technology" value="technology"></el-option>
          <el-option label="Lifestyle" value="lifestyle"></el-option>
          <el-option label="Business" value="business"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="Publish Date" prop="publishDate">
        <el-date-picker v-model="form.publishDate" type="date" placeholder="Pick a date"></el-date-picker>
      </el-form-item>
      <el-form-item label="Cover Image">
        <el-upload
          action="#"
          list-type="picture-card"
          :on-success="handleUploadSuccess"
          :auto-upload="false">
          <i class="el-icon-plus"></i>
        </el-upload>
        <img v-if="form.coverImage" :src="form.coverImage" class="cover-image-preview" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm(form)">Submit</el-button>
        <el-button>Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>
.admin-edit {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  border-radius: 8px;
  transition: all 0.3s ease;
}

.admin-edit:hover {
  box-shadow: 0 4px 24px 0 rgba(0, 0, 0, 0.2);
}

.demo-ruleForm {
  margin-top: 20px;
}

.el-form-item {
  margin-bottom: 20px;
}

.el-input, .el-select, .el-date-picker {
  width: 100%;
}

.el-button {
  margin-right: 10px;
}

.cover-image-preview {
  width: 100%;
  height: auto;
  margin-top: 10px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>