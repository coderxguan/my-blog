import axios from 'axios'

const API_URL = 'http://your-api-url/api'

export const fetchArticles = () => axios.get(`${API_URL}/articles`)
export const fetchArticle = (id) => axios.get(`${API_URL}/articles/${id}`)
export const createArticle = (articleData) => axios.post(`${API_URL}/articles`, articleData)
export const updateArticle = (articleData) => axios.put(`${API_URL}/articles/${articleData.id}`, articleData)
export const deleteArticle = (id) => axios.delete(`${API_URL}/articles/${id}`)