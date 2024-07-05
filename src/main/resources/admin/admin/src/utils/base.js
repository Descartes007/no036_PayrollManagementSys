const base = {
    get() {
        return {
            url : "http://localhost:8080/gongzi/",
            name: "gongzi",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gongzi/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "工资管理系统"
        } 
    }
}
export default base
