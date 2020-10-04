# include <stdio.h>

// 盤面サイズの定義
#define BOARD_HEIGHT 8 // 高さ
#define BOARD_WIDTH 8 // 幅

// コマの状態を定義
#define NONE 0     // 無
#define BLACK 1    // 黒
#define WHITE -1   // 白

// 盤面
char board[BOARD_HEIGHT][BOARD_WIDTH];

void InitBoard(void);
void DisplayBoard(void);

int main(void)
{
    InitBoard();

    DisplayBoard();
}

// 初期化用関数
void InitBoard(void)
{
    int x, y;
    // 縦軸
    for(y = 0; y < BOARD_HEIGHT; y++)
    {
        // 横軸
        for(x = 0; x < BOARD_WIDTH; x++)
        {
            board[y][x] = NONE;
        }
        board[BOARD_HEIGHT / 2 - 1][BOARD_WIDTH / 2 - 1] = BLACK;
        board[BOARD_HEIGHT / 2 - 1][BOARD_WIDTH / 2    ] = WHITE;
        board[BOARD_HEIGHT / 2    ][BOARD_WIDTH / 2 - 1] = WHITE;
        board[BOARD_HEIGHT / 2    ][BOARD_WIDTH / 2    ] = BLACK;
    }
}

// 盤面を表示する関数
void DisplayBoard(void)
{
    int x, y;

    printf(" ABCDEFGH\n");
    // 縦軸
    for(y = 0; y < BOARD_HEIGHT; y++)
    {
        printf("%d", y + 1);
        printf("\n");
        
        // 横軸
        for (x = 0; x < BOARD_WIDTH; x++)
        {
            switch (board[y][x])
            {
                case NONE:
                printf("・");
                break;

                case BLACK:
                printf("○");
                break;

                case WHITE:
                printf("●");
                break;

                default:
                printf("er");
                break;
            }
        }
    }

}


