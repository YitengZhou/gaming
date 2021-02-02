const statusMap = {
  0: {
    label: '禁用',
    tagType: 'warning',
    operateIcon: 'el-icon-check',
    operateLabel: '启用',
    operateBtnType: 'success'
  },
  1: {
    label: '启用',
    tagType: 'success',
    operateIcon: 'el-icon-close',
    operateLabel: '禁用',
    operateBtnType: 'warning'
  }
}

function getStatusMapArray() {
  const ret = []
  Object.keys(statusMap).forEach(property => {
    const propertyValue = statusMap[property]
    ret.push({ value: property, label: propertyValue.label })
  })
  return ret
}

function getStatusLabel(status) {
  const item = statusMap[status]
  return item ? item.label : ''
}

function getStatusTagType(status) {
  const item = statusMap[status]
  return item ? item.tagType : ''
}

function getStatusOperateIcon(status) {
  const item = statusMap[status]
  return item ? item.operateIcon : ''
}

function getStatusOperateLabel(status) {
  const item = statusMap[status]
  return item ? item.operateLabel : ''
}

function getStatusOperateBtnType(status) {
  const item = statusMap[status]
  return item ? item.operateBtnType : ''
}

export { statusMap, getStatusMapArray, getStatusLabel, getStatusTagType, getStatusOperateIcon, getStatusOperateLabel, getStatusOperateBtnType }
