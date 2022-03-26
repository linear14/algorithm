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
  let ans = arr[0];
  const dp = Array.from({ length: 2 }, () => [...arr]);

  for(let i = 1; i < n; i++) {
    dp[0][i] = Math.max(arr[i], dp[0][i-1] + arr[i]);
    dp[1][n-i-1] = Math.max(arr[n-i-1], dp[1][n-i] + arr[n-i-1]);
    ans = Math.max(ans, dp[0][i]);
  }
  
  if(n > 1) {
    ans = Math.max(ans, dp[1][1])
  }

  if(n > 2) {
    for(let i = 0; i < n-2; i++) {
      ans = Math.max(ans, dp[0][i] + dp[1][i+2]);
    }
  }

  console.log(ans);
});