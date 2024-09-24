<template>
  <div>
    <h1>{{ article.title }}</h1>
    <p>{{ article.content }}</p>
    <router-link to="/">返回主页</router-link>
  </div>
</template>

<script>
export default {
  name: 'ArticleView',
  data() {
    return {
      article: {
        title: '文章标题',
        content: '这是文章的内容。',
      },
    };
  },
};
</script>

<style scoped>
/* 文章样式 */
</style>
