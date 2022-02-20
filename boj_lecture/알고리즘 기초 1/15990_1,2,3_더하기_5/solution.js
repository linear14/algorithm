const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
const arr = [];
let dp;
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(+input);
    if(arr.length === n) rl.close();
  }
}).on('close', () => {
  const LENGTH = 100_001;
  const DIVISOR = 1_000_000_009;
  dp = Array.from({ length: LENGTH }, () => Array(3).fill(0));
  dp[1] = [1, 0, 0];
  dp[2] = [0, 1, 0];
  dp[3] = [1, 1, 1];
  
  for(let i = 4; i < LENGTH; i++) {
    dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % DIVISOR;
    dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % DIVISOR;
    dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % DIVISOR;
  }
  
  console.log(arr.map(i => ((dp[i][0] + dp[i][1]) % DIVISOR + dp[i][2]) % DIVISOR).join('\n'));
});