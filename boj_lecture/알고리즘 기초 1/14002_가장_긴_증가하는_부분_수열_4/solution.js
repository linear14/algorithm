const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
let arr;
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr = input.split(' ').map(i => +i);
    rl.close();
  }
}).on('close', () => {
  const dp = Array.from({ length: n }, () => ({ lis: 0, prev: null }));
  let ans = { idx: 0, value: 0 }
  
  for(let i = 0; i < n; i++) {
    let max = 0;
    let prev = null;
    for(let j = 0; j < i; j++) {
      if(arr[i] > arr[j] && dp[j].lis > max) {
        max = dp[j].lis;
        prev = j;
      }
    }
    dp[i].lis = max + 1;
    dp[i].prev = prev;

    if(ans.value < dp[i].lis) {
      ans.idx = i;
      ans.value = dp[i].lis;
    }
  }

  const s = [];
  let next = ans.idx;
  while(next !== null) {
    s.push(arr[next]);
    next = dp[next].prev;
  }

  console.log(ans.value);
  console.log(s.reverse().join(' '));
});