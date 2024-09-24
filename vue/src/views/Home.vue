<template>
  <div>
    <h1>博客文章</h1>
    <div v-if="articles.length">
      <ul>
        <li v-for="article in articles" :key="article.id">
          <h2>{{ article.title }}</h2>
          <p>{{ article.content }}</p>
          <p>{{article.date}}</p>
        </li>
      </ul>
    </div>
    <div v-else>
      <p>暂无文章。</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'HomeView',
  data() {
    return {
      articles: [],
    };
  },
  mounted() {
    this.fetchArticles();
  },
  methods: {
    fetchArticles() {
      axios.get('http://localhost:8080/api/articles')
          .then(response => {
            this.articles = response.data;
          })
          .catch(error => {
            console.error('获取文章失败:', error);
          });
    },
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  border: 1px solid #ddd;
  margin: 10px 0;
  padding: 10px;
}
</style>
