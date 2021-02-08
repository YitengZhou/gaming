const fastCarMap = {
    1: {
        label: '第一名',
        color: 'rgb(252,251,101)',
        oddEven: '单',
        bigSmall: '小'
    },
    2: {
        label: '第二名',
        color: 'rgb(82,137,237)',
        oddEven: '双',
        bigSmall: '小'
    },
    3: {
        label: '第三名',
        color: 'rgb(76,78,77)',
        oddEven: '单',
        bigSmall: '小'
    },
    4: {
        label: '第四名',
        color: 'rgb(233,124,55)',
        oddEven: '双',
        bigSmall: '小'
    },
    5: {
        label: '第五名',
        color: 'rgb(178,250,246)',
        oddEven: '单',
        bigSmall: '小'
    },
    6: {
        label: '第六名',
        color: 'rgb(76,36,244)',
        oddEven: '双',
        bigSmall: '大'
    },
    7: {
        label: '第七名',
        color: 'rgb(182,183,177)',
        oddEven: '单',
        bigSmall: '大'
    },
    8: {
        label: '第八名',
        color: 'rgb(238,69,48)',
        oddEven: '双',
        bigSmall: '大'
    },
    9: {
        label: '第九名',
        color: 'rgb(99,26,20)',
        oddEven: '单',
        bigSmall: '大'
    },
    10: {
        label: '第十名',
        color: 'rgb(107,181,86)',
        oddEven: '双',
        bigSmall: '大'
    }
  }
  
  function getFastCarMapArray() {
    const ret = []
    Object.keys(fastCarMap).forEach(car => {
      const carValue = fastCarMap[car]
      ret.push({ value: car, label: carValue.label })
    })
    return ret
  }
  
  function getFastCarLabel(car) {
    const item = fastCarMap[car]
    return item ? item.label : ''
  }
  
  function getFastCarColor(car) {
    const item = fastCarMap[car]
    return item ? item.color : ''
  }
  
  function getFastCarOddEven(car) {
    const item = fastCarMap[car]
    return item ? item.oddEven : ''
  }
  
  function getFastCarBigSmall(car) {
    const item = fastCarMap[car]
    return item ? item.bigSmall : ''
  }

  export { fastCarMap, getFastCarMapArray, getFastCarLabel, getFastCarColor, getFastCarOddEven, getFastCarBigSmall }