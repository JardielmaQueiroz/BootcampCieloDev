/* eslint-disable jsx-a11y/anchor-is-valid */
import { Button, Card, Label, TextInput } from "flowbite-react";
import type { FC } from "react";

const SignInPage: FC = function () {
  return (
    <div className=" w-full flex flex-col items-center justify-center px-6 lg:h-screen lg:gap-y-12 w-full">
      <Card
        horizontal
      >
        <div className="flex flex-col justify-center mb-3">
          <img alt="" src="/images/logo.svg" className="mr-3 h-6 sm:h-8" />
        </div>
        <form className="lg:w-96">
          <div className="mb-4 flex flex-col gap-y-3">
            <Label htmlFor="email">Email</Label>
            <TextInput
              id="email"
              name="email"
              placeholder="name@company.com"
              type="email"
            />
          </div>
          <div className="mb-6 flex flex-col gap-y-3">
            <Label htmlFor="password">Senha</Label>
            <TextInput
              id="password"
              name="password"
              placeholder="••••••••"
              type="password"
            />
          </div>

          <div className="my-12 flex justify-center">
            <Button type="submit" className="w-full">
              Login
            </Button>
          </div>
          <p className=" flex justify-center text-sm text-gray-500 dark:text-gray-300">
            Primeiro acesso?&nbsp;
            <a href="#" className="text-primary-600 dark:text-primary-300">
              Registre-se
            </a>
          </p>
        </form>
      </Card>
    </div>
  );
};

export default SignInPage;
