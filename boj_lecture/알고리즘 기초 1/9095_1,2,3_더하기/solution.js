const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let t;
const arr = [];
const dp = [null, 1, 2, 4];

rl.on('line', (input) => {
  if(!t) t = +input;
  else {
    arr.push(+input);
    if(arr.length === t) rl.close();
  }
}).on('close', () => {
  for(let i = 4; i < 11; i++) {
    dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
  }
  console.log(arr.map(i => dp[i]).join('\n'));
});