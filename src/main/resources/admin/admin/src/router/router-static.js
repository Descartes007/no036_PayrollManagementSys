import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jintie from '@/views/modules/jintie/list'
    import jixiao from '@/views/modules/jixiao/list'
    import xinzi from '@/views/modules/xinzi/list'
    import yuangong from '@/views/modules/yuangong/list'
    import yuangongKaoqin from '@/views/modules/yuangongKaoqin/list'
    import yuangongKaoqinList from '@/views/modules/yuangongKaoqinList/list'
    import dictionaryBumen from '@/views/modules/dictionaryBumen/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJintie from '@/views/modules/dictionaryJintie/list'
    import dictionaryJinyong from '@/views/modules/dictionaryJinyong/list'
    import dictionaryJixiao from '@/views/modules/dictionaryJixiao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryYuangongKaoqin from '@/views/modules/dictionaryYuangongKaoqin/list'
    import dictionaryYuangongKaoqinList from '@/views/modules/dictionaryYuangongKaoqinList/list'
    import dictionaryZhiwei from '@/views/modules/dictionaryZhiwei/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBumen',
        name: '部门',
        component: dictionaryBumen
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJintie',
        name: '津贴类型',
        component: dictionaryJintie
    }
    ,{
        path: '/dictionaryJinyong',
        name: '账户状态',
        component: dictionaryJinyong
    }
    ,{
        path: '/dictionaryJixiao',
        name: '绩效类型',
        component: dictionaryJixiao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYuangongKaoqin',
        name: '员工考勤类型',
        component: dictionaryYuangongKaoqin
    }
    ,{
        path: '/dictionaryYuangongKaoqinList',
        name: '打卡状态',
        component: dictionaryYuangongKaoqinList
    }
    ,{
        path: '/dictionaryZhiwei',
        name: '职位',
        component: dictionaryZhiwei
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/jintie',
        name: '津贴',
        component: jintie
      }
    ,{
        path: '/jixiao',
        name: '绩效',
        component: jixiao
      }
    ,{
        path: '/xinzi',
        name: '工资',
        component: xinzi
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }
    ,{
        path: '/yuangongKaoqin',
        name: '员工考勤',
        component: yuangongKaoqin
      }
    ,{
        path: '/yuangongKaoqinList',
        name: '员工考勤详情',
        component: yuangongKaoqinList
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
