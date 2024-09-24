
<template>
  <div class="home">
    <h1>欢迎来到我的博客</h1>
    <div class="articles">
      <div class="article-card" v-for="article in articles" :key="article.id">
        <h2>{{ article.title }}</h2>
        <p class="summary">{{ article.summary }}</p>
        <p class="date">发布日期: {{ article.date }}</p>
        <router-link class="read-more" :to="`/article/${article.id}`">阅读全文</router-link>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'HomeView',
  data() {
    return {
      articles: [
        {
          id: 1,
          title: '第一篇文章',
          summary: '这是第一篇文章的摘要，介绍了一些有趣的内容。',
          date: '2024-09-24',
        },
        {
          id: 2,
          title: '第二篇文章',
          summary: '这是第二篇文章的摘要，讨论了另一个重要话题。',
          date: '2024-09-25',
        },
        {
          id: 3,
          title: '第三篇文章',
          summary: '这是第三篇文章的摘要，分享了一些实用的技巧。',
          date: '2024-09-26',
        },
      ],
    };
  },
};
</script>

<style scoped>
.home {
  padding: 20px;
}

.articles {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.article-card {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 15px;
  background-color: #f9f9f9;
}

.summary {
  color: #555;
}

.date {
  font-size: 0.9em;
  color: #888;
}

.read-more {
  display: inline-block;
  margin-top: 10px;
  color: #007bff;
  text-decoration: none;
}

.read-more:hover {
  text-decoration: underline;
}
</style>