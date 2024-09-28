import axios from 'axios'

const API_URL = 'http://your-api-url/api'

export const fetchTags = () => axios.get(`${API_URL}/tags`)