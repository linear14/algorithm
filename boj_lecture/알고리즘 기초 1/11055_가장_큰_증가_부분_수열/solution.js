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
  const dp = Array.from({ length: n });
  let ans = 0;

  for(let i = 0; i < n; i++) {
    let max = 0;
    for(let j = 0; j < i; j++) {
      if(arr[j] < arr[i]) {
        max = Math.max(max, dp[j]);
      }
    }
    dp[i] = arr[i] + max;
    ans = Math.max(dp[i], ans);
  }
  
  console.log(ans);
});