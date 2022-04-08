const rl = require("readline").createInterface({
  input: process.stdin,
  output: process.stdout,
});

let n;
rl.on("line", (input) => {
  n = +input;
  rl.close();
}).on("close", () => {
  let ans = 0;
  while (n > 0) {
    const str = n.toString();
    const divisor = +("1".padEnd(str.length, 0));
    const count = (n - divisor) + 1;
    ans += str.length * count;

    n = divisor - 1;
  }
  console.log(ans);
});
