const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

let str;
rl.on('line', (input) => {
  str = input;
  rl.close();
}).on('close', () => {
  const ans = Array.from({ length: 26 }, () => -1);
  for(let i = 0; i < str.length; i++) {
    const idx = str.charCodeAt(i) - 97;
    if(ans[idx] === -1) {
      ans[idx] = i;
    }
  }
  console.log(ans.join(' '));
})