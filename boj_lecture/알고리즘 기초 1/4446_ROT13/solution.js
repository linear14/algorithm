const fs = require('fs');
const input = fs.readFileSync('tc.txt').toString().split('\n');

const consonants = ['a', 'i', 'y', 'e', 'o', 'u'];
const vowels = [
  'b', 'k', 'x', 'z', 'n', 
  'h', 'd', 'c', 'w', 'g', 
  'p', 'v', 'j', 'q', 't', 
  's', 'r', 'l', 'm', 'f'
]
const positionMapper = {
  a: 0, i: 1, y: 2, e: 3, o: 4, u: 5,
  b: 0, k: 1, x: 2, z: 3, n: 4, h: 5, 
  d: 6, c: 7, w: 8, g: 9, p: 10, v: 11, 
  j: 12, q: 13, t: 14, s: 15, r: 16, l: 17, 
  m: 18, f: 19
};

const isAlphabet = (char) => {
  return (char >= 'a' && char <= 'z') || (char >= 'A' && char <= 'Z');
}

const isUpperCase = (char) => {
  return (char >= 'A' && char <= 'Z');
}

const ans = [];
for(let i = 0; i < input.length - 1; i++) {
  const arr = input[i].split('');

  ans.push(
    arr.reduce((pre, cur) => {
      let temp;
    
      if(isAlphabet(cur)) {
        const curLower = cur.toLowerCase();
    
        if(consonants.includes(curLower)) {
          temp = consonants[(positionMapper[curLower] + 3) % 6]
        }
        else {
          temp = vowels[(positionMapper[curLower] + 10) % 20]
        }
    
        if(isUpperCase(cur)) {
          temp = temp.toUpperCase();
        }
      }
      else {
        temp = cur;
      }
      return pre + temp;
    }, '')
  );
} 

console.log(ans.join('\n'));