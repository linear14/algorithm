const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout
});

const sol = (cs) => {
  if(cs[0] !== 1) return 1;
  
  let last = 0, i = 0;
  do {
    last += cs[i];
  } while(++i < cs.length && last + 1 >= cs[i])

  return last + 1;
}

let n;
let cs;
rl.on('line', (line) => {
  if(!n) n = Number(line);
  else {
    cs = line.split(' ').map(i => Number(i)).sort((a, b) => a - b);
    rl.close();
  }
}).on('close', () => {
  console.log(sol(cs));
})
