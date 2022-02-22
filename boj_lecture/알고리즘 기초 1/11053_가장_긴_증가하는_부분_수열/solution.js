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
  // arr[i]가 LIS의 끝이라고 가정 할 경우의 최대 길이
  const dp = Array.from({ length: n }, () => 0);
  let ans = 0;

  for(let i = 0; i < n; i++) {
    let max = 0;
    for(let j = 0; j < i; j++) {
      if(arr[j] < arr[i]) {
        max = Math.max(max, dp[j]);
      }
    }
    dp[i] = max + 1;
    ans = Math.max(ans, dp[i]);
  }

  console.log(ans);
});