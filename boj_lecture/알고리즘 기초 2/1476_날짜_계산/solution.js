const fs = require('fs');
const input = fs.readFileSync('tc.txt').toString().split('\n');

// e: 15, s: 28, m: 19
const [te, ts, tm] = input[0].split(' ').map(i => +i);

let ans = 1;
let [e, s, m] = [1, 1, 1];

while(!(te === e && ts === s && tm === m)) {
  e = e === 15 ? 1 : e + 1;
  s = s === 28 ? 1 : s + 1;
  m = m === 19 ? 1 : m + 1;
  ans++;
}
console.log(ans);
