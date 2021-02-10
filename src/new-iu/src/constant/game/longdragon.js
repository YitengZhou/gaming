const longDragonMap = {
    firstBig: {
        value: 'firstBig',
        label: '第一名大'
    },
    firstSmall: {
        value: 'firstSmall',
        label: '第一名小'
    },
    firstOdd: {
        value: 'firstOdd',
        label: '第一名单'
    },
    firstEven: {
        value: 'firstEven',
        label: '第一名双'
    },
    firstDragon: {
        value: 'firstDragon',
        label: '第一名龙'
    },
    firstTiger: {
        value: 'firstTiger',
        label: '第一名虎'
    },
    secondBig: {
        value: 'secondBig',
        label: '第二名大'
    },
    secondSmall: {
        value: 'secondSmall',
        label: '第二名小'
    },
    secondOdd: {
        value: 'secondOdd',
        label: '第二名单'
    },
    secondEven: {
        value: 'secondEven',
        label: '第二名双'
    },
    secondDragon: {
        value: 'secondDragon',
        label: '第二名龙'
    },
    secondTiger: {
        value: 'secondTiger',
        label: '第二名虎'
    },
    thirdBig: {
        value: 'thirdBig',
        label: '第三名大'
    },
    thirdSmall: {
        value: 'thirdSmall',
        label: '第三名小'
    },
    thirdOdd: {
        value: 'thirdOdd',
        label: '第三名单'
    },
    thirdEven: {
        value: 'thirdEven',
        label: '第三名双'
    },
    thirdDragon: {
        value: 'thirdDragon',
        label: '第三名龙'
    },
    thirdTiger: {
        value: 'thirdTiger',
        label: '第三名虎'
    },
    fourthBig: {
        value: 'fourthBig',
        label: '第四名大'
    },
    fourthSmall: {
        value: 'fourthSmall',
        label: '第四名小'
    },
    fourthOdd: {
        value: 'fourthOdd',
        label: '第四名单'
    },
    fourthEven: {
        value: 'fourthEven',
        label: '第四名双'
    },
    fourthDragon: {
        value: 'fourthDragon',
        label: '第四名龙'
    },
    fourthTiger: {
        value: 'fourthTiger',
        label: '第四名虎'
    },
    fifthBig: {
        value: 'fifthBig',
        label: '第五名大'
    },
    fifthSmall: {
        value: 'fifthSmall',
        label: '第五名小'
    },
    fifthOdd: {
        value: 'fifthOdd',
        label: '第五名单'
    },
    fifthEven: {
        value: 'fifthEven',
        label: '第五名双'
    },
    fifthDragon: {
        value: 'fifthDragon',
        label: '第五名龙'
    },
    fifthTiger: {
        value: 'fifthTiger',
        label: '第五名虎'
    },
    sixthBig: {
        value: 'sixthBig',
        label: '第一名大'
    },
    sixthSmall: {
        value: 'sixthSmall',
        label: '第一名小'
    },
    sixthOdd: {
        value: 'sixthOdd',
        label: '第一名单'
    },
    sixthEven: {
        value: 'sixthEven',
        label: '第一名双'
    },
    seventhBig: {
        value: 'seventhBig',
        label: '第一名大'
    },
    seventhSmall: {
        value: 'seventhSmall',
        label: '第一名小'
    },
    seventhOdd: {
        value: 'seventhOdd',
        label: '第一名单'
    },
    seventhEven: {
        value: 'seventhEven',
        label: '第一名双'
    },
    eighthBig: {
        value: 'eighthBig',
        label: '第一名大'
    },
    eighthSmall: {
        value: 'eighthSmall',
        label: '第一名小'
    },
    eighthOdd: {
        value: 'eighthOdd',
        label: '第一名单'
    },
    eighthEven: {
        value: 'eighthEven',
        label: '第一名双'
    },
    ninthBig: {
        value: 'ninthBig',
        label: '第一名大'
    },
    ninthSmall: {
        value: 'ninthSmall',
        label: '第一名小'
    },
    ninthOdd: {
        value: 'ninthOdd',
        label: '第一名单'
    },
    ninthEven: {
        value: 'ninthEven',
        label: '第一名双'
    },
    tenthBig: {
        value: 'tenthBig',
        label: '第一名大'
    },
    tenthSmall: {
        value: 'tenthSmall',
        label: '第一名小'
    },
    tenthOdd: {
        value: 'tenthOdd',
        label: '第一名单'
    },
    tenthEven: {
        value: 'tenthEven',
        label: '第一名双'
    },
    topBig: {
        value: 'topBig',
        label: '第一名大'
    },
    topSmall: {
        value: 'topSmall',
        label: '第一名小'
    },
    topOdd: {
        value: 'topOdd',
        label: '第一名单'
    },
    topEven: {
        value: 'topEven',
        label: '第一名双'
    }
}

function getLongDragonMapArray() {
    const ret = []
    Object.keys(longDragonMap).forEach(item => {
      const itemValue = longDragonMap[item]
      ret.push({ value: item, label: itemValue.label })
    })
    return ret
  }

function getLongDragonLabel(value) {
    const item = longDragonMap[value]
    return item ? item.label : ''
  }

  export { longDragonMap, getLongDragonMapArray, getLongDragonLabel }