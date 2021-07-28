function fibonacci(num: number): number {
    if (num < 0) {
        return -1;
    } else if (num == 1 || num == 0) {
        return num;
    } else {
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}

let sum: number = 0;
console.log("10 first numbers of Fibonacci: ");
for (let i = 0; i < 10; i++) {
    console.log(fibonacci(i) + "");
    sum += fibonacci(i);
}

console.log(`Sum:  ${sum}`);