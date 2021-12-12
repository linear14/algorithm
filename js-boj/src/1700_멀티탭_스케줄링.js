const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

const sol = (holeCount, orders, remains) => {
  let ans = 0;
  let holes = [];
  
  orders.forEach(item => {
    remains.set(item, remains.get(item).slice(1));

    if(!holes.includes(item)) {
      // 비어있는 구멍이 있다면
      if(holeCount) {
        holes.push(item);
        holeCount--;
      } 
      else {
        let changeIdx = -1, nextIdx = -1;
        for(let i = 0; i < holes.length; i++) {
          const current = holes[i];
          // 더 이상 사용되지 않을 전자기기라면
          if(remains.get(current).length === 0) {
            changeIdx = i;
            break;
          }
          else {
            // 더 마지막에 사용될 전자기기라면
            if(nextIdx < remains.get(current)[0]) {
              nextIdx = remains.get(current)[0];
              changeIdx = i;
            }
          }
        }
        holes[changeIdx] = item;
        ans++;
      }
    }
  })
  return ans;
}

let holeCount;
let orders;
let remains;
rl.on('line', (line) => {
  if(!holeCount) {
    const [iHoleCount, _] = line.split(' ').map(i => Number(i));
    holeCount = iHoleCount;
  }
  else {
    orders = line.split(' ').map(i => Number(i));
    remains = orders.reduce((pre, order, idx) => {
      pre.set(order, [...(pre.get(order) || []), idx]);
      return pre;
    }, new Map());
    rl.close();
  }
}).on('close', () => {
  console.log(sol(holeCount, orders, remains));
});

