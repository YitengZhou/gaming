const getters = {
  sidebar: state => state.app.sidebar,
  size: state => state.app.size,
  device: state => state.app.device,
  visitedViews: state => state.tagsView.visitedViews,
  cachedViews: state => state.tagsView.cachedViews,
  token: state => state.user.token,
  userId: state => state.user.userId,
  avatar: state => state.user.avatar,
  name: state => state.user.name,
  money: state => state.user.money,
  profit: state => state.user.profit,
  introduction: state => state.user.introduction,
  menu: status => status.user.menu,
  permissions: state => state.user.permissions,
  allRoutes: state => state.permission.allRoutes,
  routesDic: state => state.permission.routesDic,
  currentRoutes: state => state.permission.currentRoutes,
  errorLogs: state => state.errorLog.logs
}
export default getters
