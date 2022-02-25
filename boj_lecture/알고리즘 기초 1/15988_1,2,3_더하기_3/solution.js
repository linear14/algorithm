const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const MOD = 1_000_000_009;
const LENGTH = 1_000_001;

let n;
const arr = [];
rl.on('line', (input) => {
  if(!n) n = +input;
  else {
    arr.push(+input);
    if(arr.length === n) {
      rl.close();
    }
  }
}).on('close', () => {
  solution02();
});

/* solution 01 */
const getCount = (dp, idx) => ((dp[idx][0] + dp[idx][1]) % MOD + dp[idx][2]) % MOD;
const solution01 = () => {
  const ans = [];
  const dp = Array.from({ length: LENGTH }, () => Array(3));
  dp[1] = [1, 0, 0];
  dp[2] = [1, 1, 0];
  dp[3] = [2, 1, 1];

  for(let i = 4; i < LENGTH; i++) {
    dp[i][0] = getCount(dp, i-1);
    dp[i][1] = getCount(dp, i-2);
    dp[i][2] = getCount(dp, i-3);
  }

  arr.forEach(idx => ans.push(getCount(dp, idx)));
  console.log(ans.join('\n'));
}

/* solution 02 */
const solution02 = () => {
  const ans = [];
  const dp = [0, 1, 2, 4];
  
  for(let i = 4; i < LENGTH; i++) {
    dp[i] = (dp[i-1] + (dp[i-2] + dp[i-3]) % MOD) % MOD;
  }
  
  for(let i = 0; i < n; i++) {
    ans.push(dp[arr[i]]);
  }

  console.log(ans.join('\n'));
}