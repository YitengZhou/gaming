const serviceType = [
  { key: 'system', label: '后台服务' }
]

/**
 *
 * @param {*} value
 */
function isInServiceType(value) {
  return serviceType.some(item => item.key === value)
}

/**
 *
 * @param {*} value
 */
function getServiceLabel(value) {
  for (const item of serviceType) {
    if (item.key === value) {
      return item.label
    }
  }
  return ''
}

/**
 *
 */
function getServiceTypeTree() {
  const ret = []
  serviceType.forEach(x => {
    ret.push({
      id: x.key,
      label: x.label,
      children: []
    })
  })
  return ret
}

export { serviceType, isInServiceType, getServiceLabel, getServiceTypeTree }
