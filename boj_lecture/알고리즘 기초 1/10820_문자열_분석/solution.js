const fs = require('fs');
const input = fs.readFileSync('tc.txt').toString().split('\n');

const a = 'a'.charCodeAt(0);
const z = 'z'.charCodeAt(0);
const A = 'A'.charCodeAt(0);
const Z = 'Z'.charCodeAt(0);
const num0 = '0'.charCodeAt(0);
const num9 = '9'.charCodeAt(0);
const blank = ' '.charCodeAt(0);

for(let i = 0; i < input.length - 1; i++) {
  const ans = Array.from({ length: 4 }, () => 0); // 소 대 숫 공
  const str = input[i];
  for(let j = 0; j < str.length; j++) {
    const charCode = str.charCodeAt(j);
    if(charCode >= a && charCode <= z) ans[0]++;
    else if(charCode >= A && charCode <= Z) ans[1]++;
    else if(charCode >= num0 && charCode <= num9) ans[2]++;
    else if(charCode === blank) ans[3]++;
  }
  console.log(ans.join(' '));
}