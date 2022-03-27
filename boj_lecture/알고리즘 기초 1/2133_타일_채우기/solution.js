const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let n;
rl.on('line', (input) => {
  n = +input;
  rl.close();
}).on('close', () => {
  const dp = [1];

  for(let i = 1; i <= n; i++) {
    if(i % 2 === 1) dp.push(1)
    else {
      if(i === 2) dp.push(3);
      else {
        let value = dp[i-2];
        for(let j = 0; j < i; j+=2) {
          value += dp[j] * 2;
        }
        dp.push(value);
      }
    }
  }

  if(n % 2 === 1) {
    console.log(0);
  }
  else {
    console.log(dp[n]);
  }
});