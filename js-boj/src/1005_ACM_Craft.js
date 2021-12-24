const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
})

let t;
let cur = 1;
const nkInput = [];
const timeInput = [];
const orderInput = [];
const targetInput = [];

rl.on('line', (input) => {
  if(!t) t = +input;
  else if(cur <= t) {
    if(nkInput.length < cur) {
      nkInput.push(input.split(' ').map(i => +i));
    }
    else if(timeInput.length < cur) {
      timeInput.push(input.split(' ').map(i => +i));
    }
    else if(orderInput.length < cur || orderInput[cur - 1].length < nkInput[cur - 1][1]) {
      if(orderInput.length < cur) orderInput.push([]);
      orderInput[cur - 1].push(input.split(' ').map(i => +i));
    }
    else if(targetInput.length < cur) {
      targetInput.push(+input);
      
      if(cur < t) cur++;
      else rl.close();
    }
  }
}).on('close', () => {
  for(let i = 0; i < t; i++) {
    console.log(sol(i));
  }
})

const sol = (i) => {
  const [n, k] = nkInput[i];
  const times = timeInput[i];
  const orders = orderInput[i];
  const target = targetInput[i];

  const linkedMap = new Map();
  orders.forEach(([from, to]) => {
    const newArr = linkedMap.has(to) ? linkedMap.get(to) : [];
    newArr.push(from);
    linkedMap.set(to, newArr);
  })

  const dp = Array(n).fill(null);
  const dfs = (idx) => {
    if(dp[idx] === null) {
      dp[idx] = times[idx];
      
      let max = 0;
      const links = linkedMap.has(idx + 1) ? linkedMap.get(idx + 1) : [];
      for(let i = 0; i < links.length; i++) {
        max = Math.max(max, dfs(links[i] - 1));
      }
      dp[idx] += max;
    }
    return dp[idx];
  }

  return dfs(target - 1);
}