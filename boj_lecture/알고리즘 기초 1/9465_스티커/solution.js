const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const ans = [];

let t;
let n;
let dp;
let counter = 0;
rl.on('line', (input) => {
  if(!t) t = +input;
  else {
    if(!n) {
      n = +input;
      dp = Array.from({ length: 2 });
    }
    else {
      dp[counter++] = input.split(' ').map(i => +i);
      if(counter === 2) {
        solve();
        n = undefined;
        counter = 0;
      }
    }
  }

  if(ans.length === t) {
    console.log(ans.join('\n'));
    rl.close();
  }
})

const solve = () => {
  if(n > 1) {
    dp[0][1] += dp[1][0];
    dp[1][1] += dp[0][0];
  }
  for(let i = 2; i < n; i++) {
    dp[0][i] += Math.max(dp[1][i-1], dp[1][i-2]);
    dp[1][i] += Math.max(dp[0][i-1], dp[0][i-2]);
  }
  ans.push(Math.max(dp[0][n-1], dp[1][n-1]));
}