const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const idxMapper = {
  'a': 0, 'b': 1, 'c': 2, 'd': 3, 'e': 4,
  'f': 5, 'g': 6, 'h': 7, 'i': 8, 'j': 9,
  'k': 10, 'l': 11, 'm': 12, 'n': 13, 'o': 14,
  'p': 15, 'q': 16, 'r': 17, 's': 18, 't': 19,
  'u': 20, 'v': 21, 'w': 22, 'x': 23, 'y': 24,
  'z': 25
};

// solution 1
/*
  let str;
  rl.on('line', (input) => {
    str = input;
    rl.close();
  }).on('close', () => {
    const ans = Array.from({ length: 26 }, () => 0);
    for(let i = 0; i < str.length; i++) {
      const idx = idxMapper[str[i]];
      ans[idx]++;
    }
    console.log(ans.join(' '));
  })
*/

// solution 2
let str;
rl.on('line', (input) => {
  str = input;
  rl.close();
}).on('close', () => {
  const ans = Array.from({ length: 26 }, () => 0);
  for(let i = 0; i < str.length; i++) {
    const idx = str.charCodeAt(i) - 'a'.charCodeAt(0);
    ans[idx]++;
  }
  console.log(ans.join(' '));
})