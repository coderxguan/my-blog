export function formatDate(date) {
    const d = new Date(date)
    return d.toLocaleDateString('zh-CN', { year: 'numeric', month: 'long', day: 'numeric' })
}