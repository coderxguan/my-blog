import axios from 'axios';

const API_URL = 'http://localhost:8080/api/admin/category'; // Adjust the URL as needed

// Fetch categories from the server
export const fetchCategories = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data.data; // Assuming this matches the structure you provided
    } catch (error) {
        console.error('Error fetching categories:', error);
        throw error; // Rethrow or handle error as needed
    }
};

// 添加分类
export const addCategoryToServer = async (category) => {
    try {
        const response = await axios.post(API_URL, category, {
            headers: {
                'Content-Type': 'application/json', // 确保设置正确的内容类型
            },
        });
        return response.data; // 返回后端返回的数据
    } catch (error) {
        console.error('Error adding category:', error);
        throw error; // 重新抛出或处理错误
    }
};

// 删除分类
export const deleteCategoryFromServer = async (categoryId) => {
    try {
        const response
            = await axios.delete(`${API_URL}/${categoryId}`); // 使用模板字符串
        return response.data; // 返回后端返回的数据
    } catch (error) {
        console.error('Error deleting category:', error);
        throw error; // 重新抛出或处理错误
    }
};

//  更新分类
export const updateCategoryToServer = async (category) => {
        try{
            const response = await axios.put(`${API_URL}/${category.id}`, category, {
                headers: {
                    'Content-Type': 'application/json',
                },
            });
            return response.data;  // 返回后端数据
        }catch(error){
            console.error('Error updating category:', error);
            throw error;
        }
}