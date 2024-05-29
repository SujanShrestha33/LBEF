using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace EduQuestHub.Server.Migrations
{
    public partial class test : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "CourseId1",
                table: "Feedbacks",
                type: "int",
                nullable: true);

            migrationBuilder.CreateIndex(
                name: "IX_Feedbacks_CourseId1",
                table: "Feedbacks",
                column: "CourseId1");

            migrationBuilder.AddForeignKey(
                name: "FK_Feedbacks_Courses_CourseId1",
                table: "Feedbacks",
                column: "CourseId1",
                principalTable: "Courses",
                principalColumn: "CourseId");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Feedbacks_Courses_CourseId1",
                table: "Feedbacks");

            migrationBuilder.DropIndex(
                name: "IX_Feedbacks_CourseId1",
                table: "Feedbacks");

            migrationBuilder.DropColumn(
                name: "CourseId1",
                table: "Feedbacks");
        }
    }
}
